package com.example.climex.business.servicesimpl;

import com.example.climex.business.services.CustomerService;
import com.example.climex.business.services.FileService;
import com.example.climex.dao.repositories.CustomerRepository;
import com.example.climex.utils.dtos.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class XmlFileService implements FileService {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Override
    public boolean readFile(MultipartFile file) {
        List<CustomerDto> customers = new ArrayList<CustomerDto>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file.getInputStream());

            NodeList customerNodes = document.getElementsByTagName("row");
            for (int i = 0; i < customerNodes.getLength(); i++) {
                Element customerElement = (Element) customerNodes.item(i);
                String nom = getTextContentByTagName(customerElement, "nom");
                String prenom = getTextContentByTagName(customerElement, "prenom");
                int age = Integer.parseInt(getTextContentByTagName(customerElement, "age"));
                String profession = getTextContentByTagName(customerElement, "profession");
                double salaire = Double.parseDouble(getTextContentByTagName(customerElement, "salaire"));

                CustomerDto customer = new CustomerDto(nom, prenom, age, profession, salaire);
                customers.add(customer);
            }

            customerRepository.saveAll(customerService.convertListDtoToListEntity(customers));

            return true;
        } catch (Exception e) {
            log.info(":::::::::::::::: echec :::::::::::::::");
        }

        return false;
    }

    private String getTextContentByTagName(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }
}
