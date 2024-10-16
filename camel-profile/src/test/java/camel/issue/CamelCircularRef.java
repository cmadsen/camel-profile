package camel.issue;

import static org.assertj.core.api.Assertions.*;

import org.apache.camel.CamelContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
// @ExtendWith(SpringExtension.class)
// @ContextConfiguration(initializers =
// CamelCircularRef.XmlConfigInitializer.class)
@ActiveProfiles("circular")
class CamelCircularRef {

	@Autowired
	private CamelContext camelContext;

	@Test
	void testCamelConfig() {
		try {
			assertThat(camelContext).isNotNull();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Configuration
	@ImportResource("classpath:XmlConfigCircular.xml")
	static class TestConfig {
	}

	public static class XmlConfigInitializer implements
			ApplicationContextInitializer<GenericApplicationContext> {
		@Override
		public void initialize(GenericApplicationContext context) {
			String[] activeProfiles = context.getEnvironment()
					.getActiveProfiles();
			for (String profile : activeProfiles) {
				if ("circular".equals(profile)) {
					XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(
							context);
					xmlReader.loadBeanDefinitions(
							new ClassPathResource("XmlConfigCircular.xml"));
				}
			}
		}
	}

}