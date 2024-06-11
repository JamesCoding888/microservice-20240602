package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/api")
public class ApiController implements HealthIndicator{
	
	@Autowired
	private EurekaClient eurekaClient;
	
	
	@GetMapping
	public String index() {
		return "Welcome to Home page";
	}
	
	@GetMapping("/down")
	public String down() {
		InstanceInfo instanceInfo = eurekaClient.getApplicationInfoManager().getInfo();
		instanceInfo.setStatus(InstanceInfo.InstanceStatus.DOWN);
		return "Welcome service: DOWN";
	}
	
	@GetMapping("/up")
	public String up() {
		InstanceInfo instanceInfo = eurekaClient.getApplicationInfoManager().getInfo();
		instanceInfo.setStatus(InstanceInfo.InstanceStatus.UP);
		return "Welcome service: UP";
	}
	
	@GetMapping("/healthdown")
	@Override
    public Health health() {
        InstanceInfo instanceInfo = eurekaClient.getApplicationInfoManager().getInfo();
        instanceInfo.setStatus(InstanceInfo.InstanceStatus.DOWN);
        return Health.down().withDetail("reason", "Manually marked as DOWN").build();
    }
}
