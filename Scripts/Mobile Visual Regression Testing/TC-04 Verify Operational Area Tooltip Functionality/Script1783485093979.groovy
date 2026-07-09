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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.annotation.Keyword as Keyword

Mobile.startExistingApplication(GlobalVariable.ApplicationId)

//tap rent revamp button on home mybb
Mobile.tap(findTestObject('Mobile Visual Regression Testing/Home/btnRent'), 0)

//tap tooltip button on home rent revamp
Mobile.tap(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/btntooltip'), 15)

//verify text bb,sb,gb showed
// Verify Bluebird
CustomKeywords.'helper.helper.TextHelper.verifyText'(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/lblbluebird'), 
    'Bluebird')

// Verify Silver Bird
CustomKeywords.'helper.helper.TextHelper.verifyText'(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/lblSilverbird'), 
    'Silverbird')

// Verify Golden Bird
CustomKeywords.'helper.helper.TextHelper.verifyText'(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/lblGoldenbird'), 
    'Goldenbird')

//button oke,mengerti direct to homepage rent revamp
Mobile.tap(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/btnoke2'), 0)

//verify home tampil setelah button oke,mengerti
Mobile.verifyElementVisible(findTestObject('Mobile Visual Regression Testing/Home/lblGreeting'),10)

//tap tooltip button on home rent revamp
Mobile.tap(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/btntooltip'), 15)

//button exit direct to homepage rent revamp
Mobile.tap(findTestObject('Object Repository/Mobile Visual Regression Testing/Home/btnexit2'), 15)

//verify home tampil setelah button exit
Mobile.verifyElementVisible(findTestObject('Mobile Visual Regression Testing/Home/lblGreeting'), 10)

