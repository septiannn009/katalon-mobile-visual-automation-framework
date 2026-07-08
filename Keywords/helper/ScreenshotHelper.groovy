package helper

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class ScreenshotHelper {


	@Keyword
	def capture(String imageName) {


		Mobile.takeScreenshot(
			"ActualImages/" 
			+ imageName 
			+ ".png"
		)


	}

}