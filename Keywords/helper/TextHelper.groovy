package helper
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject

class TextHelper {

    @Keyword
    def verifyText(TestObject object, String expected, int timeout = 5) {

    String actual = Mobile.getText(object, timeout)

    println "========== VERIFY TEXT =========="
    println "Expected : ${expected}"
    println "Actual   : ${actual}"
    println "================================="

    Mobile.verifyEqual(actual, expected)
}
}