package br.com.fatec.apphotel.controller;

import br.com.fatec.apphotel.controller.dto.ServicoDTO;
import br.com.fatec.apphotel.controller.mapper.ServicoMapper;
import br.com.fatec.apphotel.controller.request.ServicoEntrypointRequest;
import br.com.fatec.apphotel.modelo.Servico;
import br.com.fatec.apphotel.repository.ServicoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Classe reesponsável por conter os endpoints referente ao Servico
 *
 * @author Kim Tsunoda
 * @since 20/11/2020
 */
@Api(value = "ServicoController", tags = "Servico Controller", description = "Controller de Servicos")
@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    /**
     * Método responsável por cadastrar um Servico no banco de dados
     *
     * @param {@code ServicoEntrypointRequest}
     * @param {@code UriComponentsBuilder}
     * @return {@code ResponseEntity<ServicoDTO>}
     */
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ServicoDTO> cadastrarServico ( @RequestBody @Valid ServicoEntrypointRequest servicoRequest ,
                                                         UriComponentsBuilder uriBuilder ) {

        Servico servico = ServicoMapper.toDomain ( servicoRequest );
        servicoRepository.save ( servico );

        URI uri = uriBuilder.path ( "/servicos/{codigo}" ).buildAndExpand ( servico.getCodigo ( ) ).toUri ( );
        return ResponseEntity.created ( uri ).body ( new ServicoDTO ( servico ) );
    }

    /**
     * Método responsável por listar todos os Servicos cadastrados no banco de dados
     *
     * @return {@code List<ServicoDTO>}
     */
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<ServicoDTO> listarServicos () {

        List<Servico> servicos = servicoRepository.findAll ( );

        return ServicoDTO.converter ( servicos );
    }

    /**
     * Método responsável por buscar um Servico cadastrado no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<ServicoDTO>}
     */
    @GetMapping("/{codigo}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ServicoDTO> detalharServico ( @PathVariable Long codigo ) {

        Optional<Servico> servico = servicoRepository.findByCodigo ( codigo );
        if (servico.isPresent ( )) {
            return ResponseEntity.ok ( new ServicoDTO ( servico.get ( ) ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por atualizar as informações de um Servico cadastrado no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<ServicoDTO>}
     */
    @PutMapping(value = "/{codigo}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ServicoDTO> atualizarServico ( @PathVariable Long codigo , @RequestBody @Valid ServicoEntrypointRequest servicoRequest ) {

        Optional<Servico> optional = servicoRepository.findByCodigo ( codigo );
        if (optional.isPresent ( )) {
            Servico topico = servicoRequest.atualizar ( codigo , servicoRepository );
            return ResponseEntity.ok ( new ServicoDTO ( topico ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por realizar a deleção de um Servico cadastrado no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<?>}
     */
    @DeleteMapping("/{codigo}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletarServico ( @PathVariable Long codigo ) {

        Optional<Servico> servico = servicoRepository.findByCodigo ( codigo );
        if (servico.isPresent ( )) {
            servicoRepository.deleteById ( servico.get ( ).getCodigo ( ) );
            return ResponseEntity.ok ( ).build ( );
        }

        return ResponseEntity.notFound ( ).build ( );
    }
}