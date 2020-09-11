Guidelines to run the Project

Step 1: import the project to eclipse
Step 2: Once import done, right click on the project and do maven -> update
Step 3: Again right click on the project and do Run As -> Maven Install
Step 4: Go to CustomerRatingApplication.java, right click on it Run As -> Java Application
Step 5: Confirm once go to database by entering "http://localhost:10090/h2-console/login.do?" in the URL area. 
		Make sure that the JDBC URL shouls be "jdbc:h2:mem:testdb" and leave password blank. Click on connect 
		and check whether the data is inserted into the tables successfully
Step 6: 

Once you see "Completed initialization in X ms", open Restfull client and provide

	Endpoint1: http://localhost:10090/api/rest/customer/{customerId}/movie/{movieId}/rate/{rateId}

	Sample URL: localhost:10090/api/rest/customer/1/movie/1/rate/1
	Response: "Record inserted with id : XX"
	
all the input values should be integer only and range of the values should be 1 t0 5. Since in CustomerRatingApplication.java, inserted 
we are inserting only 5 records per table

	Endpoint2: http://localhost:10090/api/rest/customer/highestMovieRated
	Response: "Highest Movie Rating is : XXXXXXX"
	
	Endpoint3: http://localhost:10090/api/rest/customer/getAvgHighestRating
	Response: if data is there in the table, we will get the response like below
				{
				    "id": 2,
				    "firstName": "Chloe",
				    "lastName": "O'Brian",
				    "customerAverageRating": 3,
				    "averageRating": 3
				}
	
	if no data then
		{
		    "id": null,
		    "firstName": null,
		    "lastName": null,
		    "customerAverageRating": null,
		    "averageRating": null
		}

	
	