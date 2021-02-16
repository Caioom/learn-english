package com.caio.englishlearn.integration.entities

import javax.persistence.*

@Entity
@Table(name = "verb_tenses")
data class VerbEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @Column(name = "imperative")
    var imperative: String = "",

    @Column(name = "simple_past")
    var simplePast: String = "",

    @Column(name = "past_participle")
    var pastParticiple: String = "",

    @Column(name= "translation")
    var translation: String = "",
)
