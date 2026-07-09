import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
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
import com.kms.katalon.core.util.KeywordUtil

Mobile.startExistingApplication(GlobalVariable.ApplicationId)

//tap rent revamp button on home mybb
Mobile.tap(findTestObject('Mobile Visual Regression Testing/Home/btnRent'), 0)

//verify nama yang tampil apakah sudah sesuai atau belum
Mobile.verifyElementVisible(
	findTestObject('Mobile Visual Regression Testing/Home/lblGreeting'),
	10
)

//log untuk bandingkan expected sama actual nama yang tampil dengan set yang ada di profiles
String actualGreeting = Mobile.getText(
	findTestObject('Mobile Visual Regression Testing/Home/lblGreeting'),
	10
).trim()

String expectedGreeting = "Hai ${GlobalVariable.FirstName},"

println "Expected : ${expectedGreeting}"
println "Actual   : ${actualGreeting}"

if (actualGreeting == expectedGreeting) {
	KeywordUtil.markPassed("Greeting sesuai. Actual: ${actualGreeting}")
} else {
	KeywordUtil.markFailedAndStop(
		"Greeting tidak sesuai.\nExpected: ${expectedGreeting}\nActual: ${actualGreeting}"
	)
}

//verify placeholder tampil ketika lokasi tidak mencakupi lokasi
Mobile.verifyElementVisible(
	findTestObject('Mobile Visual Regression Testing/Home/lblPlaceholder'),
	10
)

String actualPlaceholder = Mobile.getText(
	findTestObject('Mobile Visual Regression Testing/Home/lblPlaceholder'),
	10
).trim()

String expectedPlaceholder = "Sewa di mana?"

if (actualPlaceholder == expectedPlaceholder) {
	KeywordUtil.markPassed("Placeholder sesuai")
} else {
	KeywordUtil.markFailedAndStop(
		"Placeholder tidak sesuai.\nExpected: ${expectedPlaceholder}\nActual: ${actualPlaceholder}"
	)
}

//Cek button order masih disable dan ketika klik tidak bisa dan tetap berada dihalaman rent home
Mobile.tap(
    findTestObject('Rent Revamp Env Regress/Home/btnSewaOrder'),
    0,
    FailureHandling.OPTIONAL
)
