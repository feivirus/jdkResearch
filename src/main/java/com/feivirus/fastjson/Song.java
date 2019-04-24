package com.feivirus.fastjson;

import lombok.Data;

@Data
public class Song {
    private String name;
    
    private SongsEnum songsEnum;
    
    private SongsStatusEnum statusEnum;
}
