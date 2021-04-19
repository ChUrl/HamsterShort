package de.churl.hamstershort.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "links")
data class Link(

        @Column(name = "url")
        val url: String,

        @Column(name = "name")
        val name: String,

        @Column(name = "shorturl")
        val shorturl: String
) {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(name = "link_id")
    val id: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")
}
