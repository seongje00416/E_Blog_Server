package org.eun.e_blog.post.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.eun.e_blog.util.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@FieldNameConstants
@NoArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private Long userID;
    private String title;
    private String content;
    @Enumerated( EnumType.STRING )
    private PostType postType;
    @Enumerated( EnumType.STRING )
    private PostAccess postAccess;
    @OneToMany
    private List<PostFile> fileList;
    @OneToMany
    private List<PostFile> imageList;
    private LocalDateTime deletedAt;

    @Builder
    public Post( Long id, Long userID, String title, String content, PostType postType, PostAccess postAccess ){
        this.id = id;
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.postType = postType;
        this.postAccess = postAccess;
        this.deletedAt = null;
        this.fileList = new ArrayList<PostFile>();
        this.imageList = new ArrayList<PostFile>();
    }

    public void delete( LocalDateTime time ) { this.deletedAt = time; }
}