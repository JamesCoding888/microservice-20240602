package com.example.demo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LombokTest {
	private Integer id;
	private String name;
	private Integer price;
	private Integer cost;
	private Integer quantity;
	
	public static void main(String[] args) {
		LombokTest l = new LombokTest();
		l.setName("lombok test");
		String name = l.getName();
		System.out.println(name);
		
		LombokTest lArgs = new LombokTest(1, "lombok", 100, 50, 1);
		System.out.println(lArgs);
	}
}
