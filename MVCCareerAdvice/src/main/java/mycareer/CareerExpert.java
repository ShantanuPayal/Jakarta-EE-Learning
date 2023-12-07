package mycareer;

public class CareerExpert {
	 public String getCareerAdvice(int tenthMarks, int twelfthMarks) {
	        int aggregate = (tenthMarks + twelfthMarks) / 2;
	        String advice;

	        if (aggregate > 75) {
	            advice = "Science stream careers advice";
	            advice += "<br><br><b>Top career choices:</b><br>";
	            advice += "1. Doctor<br>";
	            advice += "2. Engineer<br>";
	            advice += "3. Pilot<br>";
	            // Add more choices as needed
	        } else if (aggregate >= 60 && aggregate <= 75) {
	            advice = "Commerce field career options advice";
	            advice += "<br><br><b>Top career choices:</b><br>";
	            advice += "1. Accountant<br>";
	            advice += "2. Business Analyst<br>";
	            advice += "3. Economist<br>";
	            // Add more choices as needed
	        } else {
	            advice = "Arts stream careers advice";
	            advice += "<br><br><b>Top career choices:</b><br>";
	            advice += "1. Writer<br>";
	            advice += "2. Teacher<br>";
	            advice += "3. Graphic Designer<br>";
	            // Add more choices as needed
	        }
	        
	        return advice;
	    }
}
