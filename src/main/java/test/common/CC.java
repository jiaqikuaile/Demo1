package test.common;

public class CC {
	  public static String getStackTraceString(Throwable ex){//(Exception ex) {
	        StackTraceElement[] traceElements = ex.getStackTrace();
	 
	        StringBuilder traceBuilder = new StringBuilder();
	 
	        if (traceElements != null && traceElements.length > 0) {
	            for (StackTraceElement traceElement : traceElements) {
	                traceBuilder.append(traceElement.toString());
	                traceBuilder.append("\n");
	            }   //
	        }
	 
	        return traceBuilder.toString();
	    }
}
