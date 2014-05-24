package com.tobrun.android.test.uiautomator;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ApiDemosTest extends UiAutomatorTestCase {

	/* App name */
	private final static String API_DEMOS = "API Demos";

	/* Text items */
	private final static String TEXT = "Text";
	private final static String LOGTEXTBOX = "LogTextBox";
	private final static String ADD = "Add";
	private final static String EMPTY = "";
	private final static String THIS_IS_A_TEST = "This is a test";

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Log
		Logger.d(ApiDemosTest.class.getName(), "setUp start");

		// go home
		Logger.d(ApiDemosTest.class.getName(), "setUp go home");
		UiAutomatorUtils.clickOnHomeButton(this);

		// open the application to test
		Logger.d(ApiDemosTest.class.getName(), "setUp open Api Demos");
		UiAutomatorUtils.openApplication(this, API_DEMOS);

		// click on "Text" ListView item
		Logger.d(ApiDemosTest.class.getName(), "setUp click 'Text' menu item");
		UiAutomatorUtils.clickOnListViewItem(TEXT);

		// click on "LogTextBox" ListView item
		Logger.d(ApiDemosTest.class.getName(), "setUp click 'LogTextBox' menu item");
		UiAutomatorUtils.clickOnListViewItem(LOGTEXTBOX);

		// Log
		Logger.d(ApiDemosTest.class.getName(), "setUp finish");

	}

	/**
	 * Test if the initial state of the button is visible & enabled
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void testLogTextBoxInitialStateButton() throws UiObjectNotFoundException {
		Logger.d(ApiDemosTest.class.getName(), "TEST : testing the initial state of the button");
		final UiObject addButton = UiAutomatorUtils.findButtonByText(ADD);
		assertTrue(addButton.exists() && addButton.isEnabled());
	}

	/**
	 * Test if the initial state of the textview is empty
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void testLogTextBoxInitialStateTextView() throws UiObjectNotFoundException {
		Logger.d(ApiDemosTest.class.getName(), "TEST : testing the initial state of the textview");
		final UiObject layout = new UiObject(new UiSelector().className(FrameLayout.class.getName()).index(1));
		final UiObject textview = layout.getChild(new UiSelector().className(TextView.class.getName()));
		assertTrue(EMPTY.equals(textview.getText()));
	}

	/**
	 * Test if the secondary state after the button was clicked
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void testLogTextBoxSingleClickedState() throws UiObjectNotFoundException {
		Logger.d(ApiDemosTest.class.getName(), "TEST : testing the single clicked state of the button");
		UiAutomatorUtils.findButtonByText(ADD).click();
		final UiObject layout = new UiObject(new UiSelector().className(FrameLayout.class.getName()).index(1));
		final UiObject textview = layout.getChild(new UiSelector().className(TextView.class.getName()));
		assertTrue(textview.getText().contains(THIS_IS_A_TEST));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();

		// Log
		Logger.d(ApiDemosTest.class.getName(), "tearDown start");

		// go back until app closes
		UiAutomatorUtils.clickOnBackButton(this, 4);

		// Log
		Logger.d(ApiDemosTest.class.getName(), "tearDown finish");

	}

}
