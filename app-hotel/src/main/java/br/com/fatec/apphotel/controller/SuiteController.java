package br.com.fatec.apphotel.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.apphotel.controller.dto.SuiteDTO;
import br.com.fatec.apphotel.controller.mapper.SuiteMapper;
import br.com.fatec.apphotel.controller.request.SuiteEntrypointRequest;
import br.com.fatec.apphotel.modelo.Suite;
import br.com.fatec.apphotel.repository.SuiteRepository;

/**
 * Classe reesponsável por conter os endpoints referente as suítes
 *
 * @author Rafael Bispo
 * @since 18/11/2020
 */
@Api(value = "SuiteController", tags = "Suite Controller", description = "Controller de Suites")
@RestController
@RequestMapping("/suites")
public class SuiteController {

    @Autowired
    private SuiteRepository suiteRepository;

    /**
     * Método responsável por cadastrar uma suíte no banco de dados
     *
     * @param {@code SuiteEntrypointRequest}
     * @param {@code UriComponentsBuilder}
     * @return {@code ResponseEntity<SuiteDTO>}
     */
    @ApiOperation(value = "Cadastrar Suite", nickname = "cadastarSuite")
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<SuiteDTO> cadastrarSuite ( @RequestBody @Valid SuiteEntrypointRequest suiteRequest ,
                                                     UriComponentsBuilder uriBuilder ) {

        Suite suite = SuiteMapper.toDomain ( suiteRequest );
        suiteRepository.save ( suite );

        URI uri = uriBuilder.path ( "/suites/{id}" ).buildAndExpand ( suite.getId ( ) ).toUri ( );

        return ResponseEntity.created ( uri ).body ( new SuiteDTO ( suite ) );
    }
    
    /**
     * Método responsável por listar todos as suítes cadastradas no banco de dados
     *
     * @return {@code List<SuiteDTO>}
     */
    @ApiOperation(value = "listar Suite", nickname = "listarSuite")
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<SuiteDTO> listarSuite () {

        List<Suite> suites = suiteRepository.findAll ( );

        return SuiteDTO.converter ( suites );
    }

    /**
     * Método responsável por buscar uma suíte cadastrada no banco de dados a partir de seu id
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<SuiteDTO>}
     */
    @ApiOperation(value = "Detalhar Suite", nickname = "detalharSuite")
    @GetMapping(value = "/{id}")
    public ResponseEntity<SuiteDTO> detalharSuite ( @PathVariable Long id ) {

        Optional<Suite> suite = suiteRepository.findById ( id );
        if (suite.isPresent ( )) {
            return ResponseEntity.ok ( new SuiteDTO ( suite.get ( ) ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por atualizar as informações de uma suíte cadastrada no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<SuiteDTO>}
     */
    @ApiOperation(value = "Atualizar Suite", nickname = "atualizarSuite")
    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SuiteDTO> atualizarSuite ( @PathVariable Long id , @RequestBody @Valid SuiteEntrypointRequest suiteRequest ) {

        Optional<Suite> optional = suiteRepository.findById ( id );
        if (optional.isPresent ( )) {
            Suite topico = suiteRequest.atualizar ( id , suiteRepository );
            return ResponseEntity.ok ( new SuiteDTO ( topico ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por realizar a deleção de uma suíte cadastrada no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<?>}
     */
    @ApiOperation(value = "Deletar Suite", nickname = "deletarSuite")
    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletarSuite ( @PathVariable Long id ) {

        Optional<Suite> suite = suiteRepository.findById ( id );
        if (suite.isPresent ( )) {
            suiteRepository.deleteById ( suite.get ( ).getId ( ) );
            return ResponseEntity.ok ( ).build ( );
        }

        return ResponseEntity.notFound ( ).build ( );
    }
}
