package MoricCorp.Library_App.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import MoricCorp.Library_App.contract.BookWriteModel;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookTests {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void createBookTest() throws Exception{
        String title = "PrzykładT";
        String genre = "PrzykładG";
        int yearNum = 2000;
        String serialNum = "00000-00000";
        int inStockNum = 10;
        var input = new BookWriteModel(title,genre,yearNum,serialNum,inStockNum);

        mockMvc.perform(MockMvcRequestBuilders
        .post("/books")
        .content(asJsonString(input))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
        
    }
    public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }



    }
}
