package com.example.jenkinscddemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * TODO write description for class
 *
 * @author Tommy Ludwig
 */
@RestController
class AnimalEmojiController {

    final val animals: Flux<Animal> = Flux.just(Animal("elephant", "🐘"), Animal("tiger", "🐅"), Animal("koala", "🐨"))

    @GetMapping("/animals")
    fun getAllAnimals(): Flux<Animal> = animals

    @GetMapping("/animals/{name}")
    fun getSpecificAnimal(@PathVariable name: String): Mono<Animal> {
        return animals.filter { it.name == name }.singleOrEmpty()
    }

    @GetMapping
    fun getRandomAnimal(): Mono<Animal> = Mono.just(Animal("bear", "🐻"))
}

data class Animal(val name: String, val emoji: String)
