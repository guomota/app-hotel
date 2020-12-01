package br.com.fatec.apphotel.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
 * @author Gustavo Mota
 * @since 18/11/2020
 */
@Api(value = "SuiteController", tags = "Suite Controller", description = "Controller de Suites")
@RestController
@RequestMapping("/suites")
public class SuiteController {

    @Autowired
    private SuiteRepository suiteRepository;

    @PostMapping
    public ResponseEntity<SuiteDTO> cadastrarSuite ( @RequestBody @Valid SuiteEntrypointRequest suiteRequest ,
                                                     UriComponentsBuilder uriBuilder ) {

        Suite suite = SuiteMapper.toDomain ( suiteRequest );
        suiteRepository.save ( suite );

        URI uri = uriBuilder.path ( "/suites/{id}" ).buildAndExpand ( suite.getId ( ) ).toUri ( );

        return ResponseEntity.created ( uri ).body ( new SuiteDTO ( suite ) );
    }

    @GetMapping
    public List<SuiteDTO> listarSuite () {

        List<Suite> suites = suiteRepository.findAll ( );

        return SuiteDTO.converter ( suites );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SuiteDTO> detalharSuite ( @PathVariable Long id ) {

        Optional<Suite> suite = suiteRepository.findById ( id );
        if (suite.isPresent ( )) {
            return ResponseEntity.ok ( new SuiteDTO ( suite.get ( ) ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SuiteDTO> atualizarSuite ( @PathVariable Long id , @RequestBody @Valid SuiteEntrypointRequest suiteRequest ) {

        Optional<Suite> optional = suiteRepository.findById ( id );
        if (optional.isPresent ( )) {
            Suite topico = suiteRequest.atualizar ( id , suiteRepository );
            return ResponseEntity.ok ( new SuiteDTO ( topico ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarSuite ( @PathVariable Long id ) {

        Optional<Suite> suite = suiteRepository.findById ( id );
        if (suite.isPresent ( )) {
            suiteRepository.deleteById ( suite.get ( ).getId ( ) );
            return ResponseEntity.ok ( ).build ( );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

}
