package br.com.viavarejo.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalcUtilsTest {

	@Test
	public void calcInterest_thenReturnAmount()  {
		assertThat(CalcUtils.calculateInterest(0.7386, 10, 1000.0)).isEqualTo(1076.36386677102);
		assertThat(CalcUtils.calculateInterest(0.7386, 5, 1000.0)).isEqualTo(1037.4795741464118);
		assertThat(CalcUtils.calculateInterest(0.7386, 1, 1000.0)).isEqualTo(1007.3859999999999);
		assertThat(CalcUtils.calculateInterest(2.29, 12, 2129.14)).isEqualTo(2793.8453487150728);
		assertThat(CalcUtils.calculateInterest(1.0, 3, 200.0)).isEqualTo(206.06020000000004);
		
	}
}
