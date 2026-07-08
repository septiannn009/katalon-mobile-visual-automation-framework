package helper

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import org.opencv.core.Core
import org.opencv.core.Mat
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import java.text.SimpleDateFormat


class ImageHelper {


	static {
		System.load(System.getProperty("user.dir") + "/Drivers/opencv_java4120.dll")
	}


	 


	@Keyword
def verifyElementImage(TestObject object, String baselinePath, double threshold) {


	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())


	String actualPath = "ActualImages/actual_element_${timestamp}.png"


	Mobile.takeElementScreenshot(
		actualPath,
		object
	)


	KeywordUtil.logInfo(
		"Actual Image Saved : " + actualPath
	)


	verifyImage(
		baselinePath,
		actualPath,
		threshold
	)

}



	@Keyword
	def verifyImage(String expectedPath, String actualPath, double threshold) {


		Mat expected = Imgcodecs.imread(expectedPath)

		Mat actual = Imgcodecs.imread(actualPath)


		if(expected.empty()) {

			KeywordUtil.markFailed("Baseline image not found : " + expectedPath)

			return

		}


		if(actual.empty()) {

			KeywordUtil.markFailed("Actual image not found : " + actualPath)

			return

		}



		if(expected.size() != actual.size()) {

			Imgproc.resize(actual, actual, expected.size())

		}



		Mat difference = new Mat()


		Core.absdiff(expected, actual, difference)



		Mat gray = new Mat()


		Imgproc.cvtColor(difference, gray, Imgproc.COLOR_BGR2GRAY)



		int diffPixel = Core.countNonZero(gray)


		int totalPixel = expected.rows() * expected.cols()



		double diffPercent = (diffPixel * 100.0) / totalPixel


		double matchPercent = 100 - diffPercent



		KeywordUtil.logInfo("IMAGE DIFFERENCE : " + diffPercent + "%")



		if(diffPercent > threshold) {


			Imgcodecs.imwrite("DiffImages/diff.png", difference)


			KeywordUtil.markFailed("IMAGE DIFFERENT : " + matchPercent + "%")


		} else {


			KeywordUtil.markPassed("IMAGE MATCH : " + matchPercent + "%")


		}


	}

}