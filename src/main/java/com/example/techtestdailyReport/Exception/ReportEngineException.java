package com.example.techtestdailyReport.Exception;

public class ReportEngineException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * This will set the constructor of exception class.
     *
     * @param errorMessage
     *            - This contains the error message.
     */
    public ReportEngineException(final String errorMessage) {
        super(errorMessage);
    }

    /**
     * This will set the constructor of exception class.
     *
     * @param errorMessage
     *            - This contains the error message.
     * @param e
     *            - This contains the exception object.
     */
    public ReportEngineException(final String errorMessage, final Exception e) {
        super(errorMessage, e);
    }
}
