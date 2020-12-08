package br.com.fatec.apphotel.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

import br.com.fatec.apphotel.controller.dto.ReservaDTO;
import br.com.fatec.apphotel.controller.mapper.ReservaMapper;
import br.com.fatec.apphotel.controller.request.ReservaEntrypointRequest;
import br.com.fatec.apphotel.modelo.Reserva;
import br.com.fatec.apphotel.repository.ReservaRepository;
import io.swagger.annotations.Api;

/**
 * Classe responsável por conter os endpoints referente a reserva
 *
 * @author Gustavo Mota
 * @since 17/11/2020
 */
@Api(value = "ReservaController", tags = "Reserva Controller", description = "Controller de Reserva")
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;
    
    /**
     * Método responsável por cadastrar um hospede no banco de dados
     *
     * @param {@code ReservaEntrypointRequest}
     * @param {@code UriComponentsBuilder}
     * @return {@code ResponseEntity<ReservaDTO>}
     */
    @ApiOperation(value = "Cadastrar Reserva", nickname = "cadastrarReserva")
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReservaDTO> cadastrarReserva ( @RequestBody @Valid ReservaEntrypointRequest reservaRequest , UriComponentsBuilder uriBuilder ) {

        Reserva reserva = ReservaMapper.toDomain ( reservaRequest );
        reservaRepository.save ( reserva );

        URI uri = uriBuilder.path ( "/reservas/{id}" ).buildAndExpand ( reserva.getId ( ) ).toUri ( );
        return ResponseEntity.created ( uri ).body ( new ReservaDTO ( reserva ) );
    }

    /**
     * Método responsável por listar todos as reservas cadastradas no banco de dados
     *
     * @return {@code List<ReservaDTO>}
     */
    @ApiOperation(value = "Listar Reserva", nickname = "listarReserva")
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<ReservaDTO> listarReservas () {

        List<Reserva> reserva = reservaRepository.findAll ( );

        return ReservaDTO.converter ( reserva );
    }

    /**
     * Método responsável por buscar uma reserva cadastrada no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<ReservaDTO>}
     */
    @ApiOperation(value = "Detalhar Reserva", nickname = "detalharReserva")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReservaDTO> detalharReserva ( @PathVariable Long id ) {

        Optional<Reserva> reserva = reservaRepository.findById ( id );
        if (reserva.isPresent ( )) {
            return ResponseEntity.ok ( new ReservaDTO ( reserva.get ( ) ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por atualizar as informações de uma reserva cadastrada no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<ReservaDTO>}
     */
    @ApiOperation(value = "Atualizar Reserva", nickname = "atualizarReserva")
    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReservaDTO> atualizarReserva ( @PathVariable Long id , @RequestBody @Valid ReservaEntrypointRequest reservaRequest ) {

        Optional<Reserva> optional = reservaRepository.findById ( id );

        if (optional.isPresent ( )) {
            Reserva topico = reservaRequest.atualizar ( id , reservaRepository );
            return ResponseEntity.ok ( new ReservaDTO ( topico ) );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

    /**
     * Método responsável por realizar a deleção de uma reserva no banco de dados
     *
     * @param {@code Long}
     * @return {@code ResponseEntity<?>}
     */
    @ApiOperation(value = "deletar Reserva", nickname = "deletarReserva")
    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletarReserva ( @PathVariable Long id ) {

        Optional<Reserva> reserva = reservaRepository.findById ( id );
        if (reserva.isPresent ( )) {
            reservaRepository.deleteById ( reserva.get ( ).getId ( ) );
            return ResponseEntity.ok ( ).build ( );
        }

        return ResponseEntity.notFound ( ).build ( );
    }

}
