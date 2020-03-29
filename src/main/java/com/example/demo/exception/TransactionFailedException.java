package com.example.demo.exception;

public class TransactionFailedException extends RuntimeException {

	    public TransactionFailedException(String message) {
	        super("Transaction Failed :"+message);
	    }

	    public TransactionFailedException(String message, Throwable cause) {
	        super("Transaction Failed :"+message, cause);
	    }

		public TransactionFailedException() {
			// TODO Auto-generated constructor stub
			super();
		}
	

}
