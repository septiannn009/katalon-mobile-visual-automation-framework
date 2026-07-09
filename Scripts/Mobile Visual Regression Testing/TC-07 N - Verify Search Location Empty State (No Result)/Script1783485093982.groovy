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
import java.text.SimpleDateFormat

Mobile.startExistingApplication(GlobalVariable.ApplicationId)

//tap rent revamp button on home mybb
Mobile.tap(findTestObject('Mobile Visual Regression Testing/Home/btnRent'), 0)

//verify home tampil setelah button exit
Mobile.verifyElementVisible(findTestObject('Mobile Visual Regression Testing/Home/lblGreeting'), 10)

//tap rent revamp button on home mybb
Mobile.tap(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/btnsearch4txt'), 0)

//tap delete icon untuk hapus text location autocomplete
Mobile.tap(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/btndeletetxtsearch'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

//input text 
Mobile.sendKeys(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/btnedittext2'), 'gsgffghg', FailureHandling.STOP_ON_FAILURE)

// verify lokasi tidak ditemukan wording

// Verify icon empty state
CustomKeywords.'helper.ImageHelper.verifyElementImage'(
findTestObject('Object Repository/Mobile Visual Regression Testing/Home/iconEmptyLocation'),
'BaselineImages/Icon/Outside_area.png',5
)

// Verify title
CustomKeywords.'helper.VerifyHelper.verifyText'(
    findTestObject('Object Repository/Mobile Visual Regression Testing/Home/lblverify2'),
    'Lokasi tidak ditemukan'
)

// Verify subtitle
CustomKeywords.'helper.VerifyHelper.verifyText'(
    findTestObject('Object Repository/Mobile Visual Regression Testing/Home/lblverify3'),
    'Lokasi yang dicari tidak tersedia. Silakan cari lokasi lain.'
)


