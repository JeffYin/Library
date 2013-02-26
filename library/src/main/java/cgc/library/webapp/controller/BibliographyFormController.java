package cgc.library.webapp.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cgc.library.service.BibliographyManager;

@Controller
@RequestMapping("/bibliography")
public class BibliographyFormController extends BaseFormController {
  private BibliographyManager bibliographyManager = null;

  @Autowired
  public void BibliographyManager(BibliographyManager bibliographyManager) {
		this.bibliographyManager = bibliographyManager;
  }
  
  
	/**
	 * Get cover's image
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/cover/{bibliographyId}", method = RequestMethod.GET)
	public void getCoverFromDatabase(@PathVariable Long bibliographyId, HttpServletResponse response) throws Exception {
		byte[] image = bibliographyManager.getCoverImg(bibliographyId);
		if (image!=null && image.length>0) {
			response.getOutputStream().write(image); 
		} else {
		  outputDefaultCoverImage(response); 	
		}
		
	}
	
	private void outputDefaultCoverImage(HttpServletResponse response) throws IOException {
		/* Get the default book image */
		  InputStream is = this.getClass().getClassLoader().getResourceAsStream("book-preview.png");
		  ServletOutputStream os =  response.getOutputStream(); 
		  byte[] buf = new byte[1024*16];
		  int count = 0;
        while ((count = is.read(buf)) >= 0) {
                os.write(buf, 0, count);
        }
	}
  
  private byte[] uploadCoverImage(FileUpload fileUpload, HttpServletRequest request) {
	  // validate a file was entered
	  byte[]imageData = null; 
	  byte[]imageContent = fileUpload.getFile();
      if (imageContent!=null) {
    	  MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
          CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");
          InputStream stream;
  		
  		  try {
			stream = file.getInputStream();
  			
  	        imageData = IOUtils.toByteArray(stream); 

  	        //close the stream
  	        stream.close();
  	        
  		  } catch (IOException e) {
			e.printStackTrace();
		}
      }
      return imageData; 
  }
  
  
}
