package camel.issue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootTest
// @ImportResource("classpath:XmlConfigCircular.xml")
// @ExtendWith(SpringExtension.class)
// @ContextConfiguration(initializers =
// CamelCircularRef.XmlConfigInitializer.class)
// @ActiveProfiles("circular")
class CamelCircularRef {

	// @Autowired
	// private CamelContext camelContext;

	@Test
	void testCamelConfig() {
		try {
			// assertThat(camelContext).isNotNull();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Configuration
	@ImportResource("classpath:XmlConfigCircular.xml")
	static class TestConfig {
	}

	// public static class XmlConfigInitializer implements
	// ApplicationContextInitializer<GenericApplicationContext> {
	// @Override
	// public void initialize(GenericApplicationContext context) {
	// String[] activeProfiles = context.getEnvironment()
	// .getActiveProfiles();
	// for (String profile : activeProfiles) {
	// if ("circular".equals(profile)) {
	// XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(
	// context);
	// xmlReader.loadBeanDefinitions(
	// new ClassPathResource("XmlConfigCircular.xml"));
	// }
	// }
	// }
	// }

}