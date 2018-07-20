import com.lijm.springmvc.MyMvcConfig;
import com.lijm.springmvc.service.DemoService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestControllerIngegrationTests {
    private MockMvc mockMvc;

    @Autowired
    private DemoService demoService;
    @Autowired
    WebApplicationContext was;
    @Autowired
    MockHttpSession session;
    @Autowired
    MockHttpServletRequest request;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.was).build();
    }

    @Test
    public void testNorMalController() throws Exception {
       mockMvc.perform(get("/normal"))
               .andExpect(status().isOk())
               .andExpect(view().name("page"))
       .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
       .andExpect(model().attribute("msg",demoService.saySomething()));
    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=utf-8"))
                .andExpect(content().string(demoService.saySomething()));
    }
}
