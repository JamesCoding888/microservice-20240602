package com.example.demo.service;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import com.example.demo.client.ClientService;

@Service
public class RetryService {
	
	@Autowired
	private ClientService clientService;
	
	/*
	 * Introduction to parameters of @Retryable
	 * 
	 * value: Specifies the types of exceptions that need to be retried. If not specified, retries all exceptions by default. Multiple exception types can be specified as an array.
	 *        指定需要重試的異常類型。如果沒有指定，則默認重試所有異常。可以指定多個異常類型，以陣列的形式提供
	 * maxAttempts: Specifies the maximum number of retry attempts. Default value is 3.
	 *              指定最多重試次數。默認值為 3
	 * backoff: Specifies the retry interval. You can specify an @Backoff annotation object which has two attributes:
	 * 			指定重試間隔時間。可以指定一個@Backoff註釋對象，這個對象有兩個屬性:
	 * delay: Specifies the retry interval time, default is 0 milliseconds.
	 * 		  指定重試間隔時間，默認為 0 毫秒
	 * multiplier: Specifies the multiplier for increasing the interval time with each retry, default is 1.
	 *   		   指定每次重試的間隔時間增加倍數，默認為 1
	 * include: Specifies the types of exceptions that need to be retried. Similar to 'value', but specifies retry for certain exception types.
	 * 			指定需要重試的異常類型。與value類似，但是是針對於某些異常類型進行重試
	 * exclude: Specifies the types of exceptions that should not be retried. Similar to 'value', but excludes retry for certain exception types.
	 * 			指定不需要重試的異常類型。與value類似，但是是針對於某些異常類型不進行重試
	 * */
	@Retryable(value = {IOException.class, SQLException.class, Exception.class}, maxAttempts = 4, backoff = @Backoff(delay = 3000L))
	public String getRetryResponse(String name) throws IOException, SQLException, Exception {
	    int randomValue = new Random().nextInt(100);
	    if(randomValue < 50) {
	        System.out.printf("Service B Error occurred! randomValue:%d%n", randomValue);
	        throw new SQLException(String.format("Service B encountered SQLException! randomValue:%d%n", randomValue));
	    } else if(randomValue < 80) {
	        System.out.printf("Service B Error occurred! randomValue:%d%n", randomValue);
	        throw new IOException(String.format("Service B encountered IOException! randomValue:%d%n", randomValue));
	    } else if(randomValue < 90) {
	        System.out.printf("Service B Error occurred! randomValue:%d%n", randomValue);
	        throw new Exception(String.format("Service B encountered Exception! randomValue:%d%n", randomValue));
	    }
	    System.out.println("Service B getRetryResponse OK");
	    return clientService.getResponse(name);
	}

	@Recover
	public String testRecover(IOException e) {
	    System.out.printf("IOException occurred because Retry failed: %s, so executing Recover logic%n", e.getMessage());
	    // block of code...
	    
	    return String.format("IOException occurred because Retry failed: %s, so executing Recover logic%n", e.getMessage());
	}

	@Recover
	public String testRecover(SQLException e) {
	    System.out.printf("SQLException occurred because Retry failed: %s, so executing Recover logic ", e.getMessage());
	    // block of code...
	    
	    return String.format("SQLException occurred because Retry failed: %s, so executing Recover logic ", e.getMessage());
	}
	// block of code...
	
	
	@Recover
	public String testRecover(Exception e) {
	    System.out.printf("Exception occurred because Retry failed: %s, so executing Recover logic ", e.getMessage());
	    // block of code...
	    
	    return String.format("Exception occurred because Retry failed: %s, so executing Recover logic ", e.getMessage());
	}

}
