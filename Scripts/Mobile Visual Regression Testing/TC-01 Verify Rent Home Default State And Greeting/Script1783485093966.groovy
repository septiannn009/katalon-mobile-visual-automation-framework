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

//star application
Mobile.startExistingApplication(GlobalVariable.ApplicationId)

//tap rent revamp button on home mybb
Mobile.tap(
    findTestObject('Rent Revamp Env Regress/Home/btnRent'),
    0
)

//verify nama yang tampil apakah sudah sesuai atau belum
Mobile.verifyElementVisible(
    findTestObject('Rent Revamp Env Regress/Home/lblGreeting'),
    10
)

//log untuk bandingkan expected sama actual nama yang tampil dengan set yang ada di profiles
String actualGreeting = Mobile.getText(
    findTestObject('Rent Revamp Env Regress/Home/lblGreeting'),
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

// TODO:
// Current locator is text-based ("Jakarta") because Pickup Location
// does not expose resource-id/contentDescription.
// Update locator once Android provides stable identifier.

// Verify Pickup Location Visible
Mobile.verifyElementVisible(
    findTestObject('Rent Revamp Env Regress/Home/lblPickupLocation'),
    10
)

// Get Pickup Location
String pickupLocation = Mobile.getText(
    findTestObject('Rent Revamp Env Regress/Home/lblPickupLocation'),
    10
).trim()

println "Pickup Location : ${pickupLocation}"

// Verify Pickup Location
if (pickupLocation.isEmpty()) {
    KeywordUtil.markFailedAndStop(
        "Pickup Location belum otomatis terisi"
    )
} else {
    KeywordUtil.markPassed(
        "Pickup Location berhasil otomatis terisi : ${pickupLocation}"
    )
}

// Verify Default Duration Visible
Mobile.verifyElementVisible(
	findTestObject('Rent Revamp Env Regress/Home/lblDuration'),
	10
)

String actualDuration = Mobile.getText(
	findTestObject('Rent Revamp Env Regress/Home/lblDuration'),
	10
).trim()

String expectedDuration = "2 jam"

println "Expected Duration : ${expectedDuration}"
println "Actual Duration   : ${actualDuration}"

if (actualDuration == expectedDuration) {
	KeywordUtil.markPassed("Default Duration sesuai : ${actualDuration}")
} else {
	KeywordUtil.markFailedAndStop(
		"Default Duration tidak sesuai.\nExpected: ${expectedDuration}\nActual: ${actualDuration}"
	)
}