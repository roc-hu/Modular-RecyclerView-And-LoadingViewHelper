package com.lesehome.carrot.loadingview;

public interface ResponseSender<DATA> {

	void sendError(Exception exception);

	void sendData(DATA data);

}