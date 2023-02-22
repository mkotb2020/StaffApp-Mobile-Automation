package packagestaff
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.internal.PathUtil
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
class StaffApp {

	/**
	 * Open StaffApp using APK stored in project
	 */
	@Keyword
	def  openStaffApp() {
		/*Get full directory's path of android application*/
		def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.StaffAPK, RunConfiguration.getProjectDir())
		Mobile.startApplication(appPath, false)
	}

	/**
	 * Login to staffApp
	 * @Param UserName staff app user email
	 * @Param Password staff app user password
	 */
	@Keyword
	def  loginStaffApp(String userName, String password) {
		Mobile.setText(findTestObject('Object Repository/LoginScreen/txtUserName'),userName, 0)
		Mobile.setText(findTestObject('Object Repository/LoginScreen/txtPassword'), password, 0)
		Mobile.hideKeyboard()
		Mobile.doubleTap(findTestObject('Object Repository/LoginScreen/btnLogin'), 0)
	}

	/**
	 * Logout to staffApp
	 */
	@Keyword
	def  logOutStaff() {
		Mobile.tap(findTestObject('Object Repository/HomeScreen/lblProfile'), 0)
		Mobile.tap(findTestObject('Object Repository/ProfileScreen/btnLogout'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/LoginScreen/txtUserName'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/LoginScreen/txtPassword'), 0)
	}
}