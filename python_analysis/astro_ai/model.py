from fastapi import FastAPI
from pydantic import BaseModel
import pandas as pd
import numpy as np



app = FastAPI(title="AI Service")
data = pd.read_csv('archive/ChatBot_Dataset.csv')
data = [[]]

class PredictRequest(BaseModel):
    text: str

class PredictResponse(BaseModel):
    label: str
    score: float

@app.post("/predict", response_model=PredictResponse)
async def predict(req: PredictRequest):
    text = req.text.lower()
    if "buongiorno" in text:
        return PredictResponse(label="buongiorno", score=0.98)
    return PredictResponse(label="other", score=0.5)