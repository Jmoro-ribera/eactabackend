package isst.eacta.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.common.base.Joiner;

import isst.eacta.app.modelo.AlumnoNotaAsignatura;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.List;
import java.util.Map;

public class PdfConverter {

	public void jsonToPdf(List<String> jp) throws Exception {
				
		//ObjectMapper mapper = new ObjectMapper();
        // enable pretty printing
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // read map from json file 
         //Map<String, Object> map = mapper.convertValue(jp, new TypeReference<Map<String, Object>>(){});
		
        // generate pretty JSON from map
        //String json = mapper.writeValueAsString(map);
        //String json = mapper.writeValueAsString(jp);
        // split by system new lines
        //String[] strings = json.split(System.lineSeparator());
		//String strings = Joiner.on("\r").withKeyValueSeparator(": ").join(jp);
		 
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(25, 725);
        for (int i = 0; i < jp.size(); i+=2) {
        	if(i == 0) {
        		contentStream.showText("Expediente de " + jp.get(i) + " " + jp.get(i+1) );
                contentStream.newLine();
        	}else {
            contentStream.showText(jp.get(i) + ": " + jp.get(i+1));
            }
        	
            // add line manually
            contentStream.newLine();
            contentStream.newLine();
        }
        contentStream.endText();
        contentStream.close();
        ClassPathResource classPathResource = new ClassPathResource("attachment.pdf");
        System.out.println(classPathResource.getPath());
        document.save(classPathResource.getFile());
        document.close();
       
        
	}
	
}
