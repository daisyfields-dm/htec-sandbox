package com.htec.sandbox;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WebDriverCloseExtension implements AfterAllCallback {

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		WebDriverInstance.closeWebDriver();
	}
}
