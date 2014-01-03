package pl.edu.agh.eaiib.auctions.webservices;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.edu.agh.eaiib.auctions.wsdl.GetAuctionsForManagerSoap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml", "/task-test-config.xml", "/ws-test.xml" })
public class GetAuctionsForManagerSoapTest {
    @Autowired
    GetAuctionsForManagerSoap auctionsForManagerSoap;

    @Test
    public void test() {
        Assert.assertNotNull(auctionsForManagerSoap);
    };
}