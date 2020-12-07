package br.com.fatec.apphotel.controller;

import br.com.fatec.apphotel.controller.dto.FuncionarioDTO;
import br.com.fatec.apphotel.controller.mapper.FuncionarioMapper;
import br.com.fatec.apphotel.controller.request.FuncionarioEntrypointRequest;
import br.com.fatec.apphotel.modelo.Funcionario;
import br.com.fatec.apphotel.repository.FuncionarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por conter os endpoints referente ao funcionarios
 *
 * @author Kim Tsunoda
 * @since 30/11/2020
 */
@Api(value = "FuncionarioController", tags = "Funcionario Controller", description = "Controller de Funcionarios")
@RestController
@RequestMapping("/funcionarios")
@PreAuthorize("hasRole('ADMIN')")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    /**
     * Método responsável por cadastrar um funcionario no banco de dados
     *
     * @param {@code FuncionarioEntrypointRequest}
     * @param {@code UriComponentsBuilder}
     * @return {@code ResponseEntity<FuncionarioDTO>}
     */
    @ApiOperation(value = "Cadastrar Funcionario", nickname = "cadastrarFuncionario")
    @PostMapping
    public ResponseEntity<FuncionarioDTO> cadastrarFuncionario ( @RequestBody @Valid FuncionarioEntrypointRequest funcionarioRequest ,
                                                                 UriComponentsBuilder uriBuilder ) {

        Funcionario funcionario = FuncionarioMapper.toDomain ( funcionarioRequest );
        funcionarioRepository.save ( funcionario );

        URI uri = uriBuilder.path ( "/funcionarios/{id}" ).buildAndExpand ( funcionario.getId ( ) ).toUri ( );
        return ResponseEntity.created ( uri ).body ( new FuncionarioDTO ( funcionario ) );
    }

    /**
     * Método responsável por listar todos os funcionarios cadastrados no banco de dados
     *
     * @return {@code List<FuncionarioDTO>}
     */
    @ApiOperation(value = "Listar Funcionario", nickname = "listarFuncionario")
    @GetMapping
    public List<FuncionarioDTO> listarFuncionarios () {

        List<Funcionario> funcionarios = funcionarioRepository.findAll ( );

        return FuncionarioDTO.converter ( funcionarios );
    }

    /**
     * Método responsável por buscar um funcionario cadastrado no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<HospedeDTO>}
     */
    @ApiOperation(value = "detalhar Funcionario", nickname = "detalharFuncionario")
    @GetMapping("/{nome}")
    public ResponseEntity<FuncionarioDTO> detalharFuncionario ( @PathVariable String usuario ) {

        Optional<Funcionario> funcionario = funcionarioRepository.findByUsuario ( usuario );
        if (funcionario.isPresent ( )) {
            return ResponseEntity.ok ( new FuncionarioDTO ( funcionario.get ( ) ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por atualizar as informações de um Funcionario cadastrado no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<FuncionarioDTO>}
     */
    @ApiOperation(value = "atualizar senha", nickname = "atualizarSenha")
    @PutMapping("/atualizar-senha/{id}")
    @Transactional
    public ResponseEntity<FuncionarioDTO> atualizarSenha ( @PathVariable Long id , @RequestBody @Valid FuncionarioEntrypointRequest funcionarioRequest ) {

        Optional<Funcionario> optional = funcionarioRepository.findById ( id );
        if (optional.isPresent ( )) {
            Funcionario topico = funcionarioRequest.atualizarSenha ( id , funcionarioRepository );
            return ResponseEntity.ok ( new FuncionarioDTO ( topico ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por atualizar as informações de um Funcionario cadastrado no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<FuncionarioDTO>}
     */
    @ApiOperation(value = "Atualizar Funcionario", nickname = "atualizarFuncionario")
    @PutMapping("/atualizar-funcionario/{id}")
    @Transactional
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario ( @PathVariable Long id , @RequestBody @Valid FuncionarioEntrypointRequest funcionarioRequest ) {

        Optional<Funcionario> optional = funcionarioRepository.findById ( id );
        if (optional.isPresent ( )) {
            Funcionario topico = funcionarioRequest.atualizarFuncionario ( id , funcionarioRepository );
            return ResponseEntity.ok ( new FuncionarioDTO ( topico ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por realizar a deleção de um Funcionario cadastrado no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<?>}
     */
    @ApiOperation(value = "deletar Funcionario", nickname = "deletarFuncionario")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarFuncionario ( @PathVariable Long id ) {

        Optional<Funcionario> funcionario = funcionarioRepository.findById ( id );
        if (funcionario.isPresent ( )) {
            funcionarioRepository.deleteById ( funcionario.get ( ).getId ( ) );
            return ResponseEntity.ok ( ).build ( );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

}
