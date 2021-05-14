package isst.eacta.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.MapType;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.util.Map;

public class PdfConverter {

	public void jsonToPdf(ObjectNode jp) throws Exception {
				
		ObjectMapper mapper = new ObjectMapper();
        // enable pretty printing
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // read map from json file 
        Map<String, Object> map = mapper.convertValue(jp, new TypeReference<Map<String, Object>>(){});
		
        // generate pretty JSON from map
        String json = mapper.writeValueAsString(map);
        // split by system new lines
        String[] strings = json.split(System.lineSeparator());
        
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(25, 725);
        for (String string : strings) {
            contentStream.showText(string);
            // add line manually
            contentStream.newLine();
        }
        contentStream.endText();
        contentStream.close();

        document.save("src/main/resources/attachment.pdf");
        document.close();
        
	}
	
}
