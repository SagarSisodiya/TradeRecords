package com.example.TradeRec.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.blueconic.browscap.BrowsCapField;
import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import com.example.TradeRec.dto.LeadDto;
import com.example.TradeRec.dto.ProductDto;
import com.example.TradeRec.entity.Lead;
import com.example.TradeRec.entity.Product;
import com.example.TradeRec.service.LeadService;
import com.example.TradeRec.service.ProductService;

@RestController
@RequestMapping("/product")
public class MyController {

  @Autowired
  private ProductService productService;

  @Autowired
  private LeadService leadService;

  @GetMapping
  public List<Lead> getLeadList() {
    return leadService.getLeads();
  }

  @GetMapping("/{productId}")
  public Optional<Product> getProductById(@PathVariable int productId) {
    return productService.getProductById(productId);
  }

  @PostMapping("/save")
  public void addProduct(@RequestBody ProductDto productDto) {
    Product product = new Product();
    product.setName(productDto.getProductName());
    product.setType(productDto.getType());
    productService.addProduct(product);
  }

  @DeleteMapping("/{productId}")
  public void RemoveProduct(@PathVariable int productId) {
    productService.removeProduct(productId);
  }

  @PostMapping("/saveLead")
  public RedirectView saveLead(LeadDto leadDto, RedirectAttributes ra) {
    if (StringUtils.isBlank(leadDto.getCustomerId())) {
      System.out.println("---- Inside If   ------");
      RedirectView rdView = new RedirectView("/view/showForm");
      ra.addFlashAttribute("message", "Please provide customer id");
      ra.addFlashAttribute("warning", "Do not touch the pandora box");
      return rdView;
    }

    System.out.println(
        leadDto.getCustomerId() + " " + leadDto.getFirstName() + " " + leadDto.getLastName());
    Lead lead = new Lead();
    lead.setCustomerId(leadDto.getCustomerId());
    lead.setPartnerId(leadDto.getPartnerId());
    lead.setFirstName(leadDto.getFirstName());
    lead.setLastName(leadDto.getLastName());
    lead.setLeadName(leadDto.getLeadName());
    ra.addFlashAttribute("message", leadDto.getCustomerId());
    leadService.saveLead(lead);
    return new RedirectView("/view/leadSaved");
  }

  @GetMapping("/detectDevice")
  public void detectDevice(@RequestHeader(value = "user-agent") String userAgent)
      throws IOException, ParseException {
    UserAgentParser parser =
        new UserAgentService().loadParser(Arrays.asList(BrowsCapField.DEVICE_TYPE));
    Capabilities capacilities = parser.parse(userAgent);
    System.out.println(capacilities.getDeviceType());
  }

}
