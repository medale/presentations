package ecosystem

import java.io.{File, FileOutputStream}

import org.apache.commons.io.IOUtils

import scala.sys.props
/**
	* Worksheets set current working directory to the user's home
	* directory. We want to copy american-english dictionary there.
	*/
object Setup {

	def main(args: Array[String]): Unit = {
		val dictIn = getClass.getResourceAsStream("/dictionary/american-english")
		val homeDir = props("user.home")
		val outputFile = new File(homeDir, "american-english")
		val dictOut = new FileOutputStream(outputFile)
		try {
			IOUtils.copy(dictIn, dictOut)
		} catch {
			case e: Exception => println(s"Unable to copy to ${outputFile} due to ${e}")
		} finally {
			dictIn.close()
			dictOut.close()
		}
	}
}
