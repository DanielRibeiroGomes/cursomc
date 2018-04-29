package br.com.cursomc.services.validation;

import br.com.cursomc.dto.ClienteDTO;
import br.com.cursomc.dto.ClienteNewDTO;
import br.com.cursomc.model.Cliente;
import br.com.cursomc.model.enums.TipoCliente;
import br.com.cursomc.repositories.ClienteRepository;
import br.com.cursomc.resources.exceptions.FieldMessage;
import br.com.cursomc.services.validation.util.BR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteUpdate ann){
    }

    @Override
    public boolean isValid(ClienteDTO objDTO, ConstraintValidatorContext context){

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer urlId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Cliente cliente = clienteRepository.findByEmail(objDTO.getEmail());
            if (cliente != null && !cliente.getId().equals(urlId)){
                list.add(new FieldMessage("email", "Email já existente"));
            }

        //inclua os testes aqui, inserindo erros na lista
        for(FieldMessage ex : list){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ex.getMessage()).addPropertyNode(ex.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
