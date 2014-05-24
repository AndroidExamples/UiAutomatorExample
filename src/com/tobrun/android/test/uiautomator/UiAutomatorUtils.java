package com.tobrun.android.test.uiautomator;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UiAutomatorUtils {

	private final static UiObject findViewByText(final String text, final String className) {
		return new UiObject(new UiSelector().text(text).className(className));
	}

	public static UiObject findTextViewByText(final String text) {
		return findViewByText(text, android.widget.TextView.class.getName());
	}

	public static UiObject findButtonByText(final String text) {
		return findViewByText(text, android.widget.Button.class.getName());
	}

	public static void clickOnTextView(final String text) throws UiObjectNotFoundException {
		new UiObject(new UiSelector().className(android.widget.TextView.class.getName()).text(text)).click();
	}

	public static void clickOnListViewItem(final String text) throws UiObjectNotFoundException {
		final UiScrollable listView = new UiScrollable(new UiSelector());
		listView.setMaxSearchSwipes(100);
		listView.scrollTextIntoView(text);
		listView.waitForExists(5000);
		final UiObject listViewItem = listView.getChildByText(
				new UiSelector().className(android.widget.TextView.class.getName()), "" + text + "");
		listViewItem.click();
	}

	public static void clickOnHomeButton(final UiAutomatorTestCase test) {
		test.getUiDevice().pressHome();
	}

	public static void clickOnBackButton(final UiAutomatorTestCase test, int times) {
		while (times > 0) {
			test.getUiDevice().pressBack();
			times--;
		}
	}

	public final static void openApplication(final UiAutomatorTestCase test, final String appName)
			throws UiObjectNotFoundException {

		// go home
		clickOnHomeButton(test);

		// click on menu icon
		new UiObject(new UiSelector().description("Apps")).clickAndWaitForNewWindow();

		// make UI scrollable
		final UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();

		// click on Settings app
		appViews.getChildByText(new UiSelector().className("android.widget.TextView"), appName)
				.clickAndWaitForNewWindow();

	}
}
