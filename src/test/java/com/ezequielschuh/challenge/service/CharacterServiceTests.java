package com.ezequielschuh.challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ezequielschuh.challenge.domain.Character;
import com.ezequielschuh.challenge.exception.RecordNotFoundException;
import com.ezequielschuh.challenge.repository.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTests {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CharacterService characterService;

    @Test
    public void shouldReturnAllCharacters() {

	List<Character> characters = new ArrayList<Character>();
	characters.add(new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null));
	characters.add(new Character(2, "Deadpool", "a highly trained assassin and mercenary", new Date(), null, null, null, null));

	when(characterRepository.findAll()).thenReturn(characters);

	List<Character> result = characterService.listAll();

	assertEquals(2, result.size());
	verify(characterRepository, times(1)).findAll();

    }

    @Test
    public void shouldReturnOneCharacter() {
	Optional<Character> character = Optional.ofNullable(new Character(1, "Hulk", "a green-skinned hero", new Date(), null, null, null, null));

	when(characterRepository.findById(1)).thenReturn(character);

	Character result = characterService.getById(1);

	assertEquals("Hulk", result.getName());
	assertEquals("a green-skinned hero", result.getDescription());

    }

    @Test
    public void shoutReturnNotFoundException() {

	when(characterRepository.findById(1)).thenThrow(new RecordNotFoundException("Not found exception"));

	assertThrows(RecordNotFoundException.class, () -> { characterService.getById(1); });

    }
}
