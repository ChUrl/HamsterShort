package de.churl.hamstershort

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "links")
data class Link(

    @Id
    @Column(name = "shorturl")
    val shorturl: String,

    @Column(name = "url")
    val url: String,

    @Column(name = "name")
    val name: String
)
