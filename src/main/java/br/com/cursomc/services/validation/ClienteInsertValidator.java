package br.com.cursomc.services.validation;

import br.com.cursomc.dto.ClienteNewDTO;
import br.com.cursomc.model.Cliente;
import br.com.cursomc.model.enums.TipoCliente;
import br.com.cursomc.repositories.ClienteRepository;
import br.com.cursomc.resources.exceptions.FieldMessage;
import br.com.cursomc.services.validation.util.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert ann){
    }

    @Override
    public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context){

        List<FieldMessage> list = new ArrayList<>();

        if(objDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDTO.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CPF Inválido"));
        }

        if(objDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDTO.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido"));
        }

        Cliente cliente = clienteRepository.findByEmail(objDTO.getEmail());
            if (cliente != null){
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
