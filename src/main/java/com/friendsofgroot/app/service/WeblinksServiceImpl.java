package com.friendsofgroot.app.service;

import com.friendsofgroot.app.dto.WeblinkDto;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.mapper.WeblinkMapper;
import com.friendsofgroot.app.models.Weblink;
import com.friendsofgroot.app.repositories.WeblinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeblinksServiceImpl implements WeblinksService {

    @Autowired
    WeblinkMapper weblinkMapper;

    @Autowired
    WeblinksRepository weblinksRepository;

    /**
     * @param bkmk
     * @return
     */
    @Override
    public WeblinkDto createWeblinks(WeblinkDto bkmk) {
        Weblink weblink = weblinksRepository.save(weblinkMapper.toEntity(bkmk));
        return weblinkMapper.toDto(weblink);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public WeblinkDto getWeblinks(long id) {
        try {
            return weblinkMapper.toDto(weblinksRepository.findById(id).get());
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * @param bkmk
     * @return
     */
    @Override
    public List<WeblinkDto> getAllWeblinks() {
        List<WeblinkDto> wdto = null;
        List<Weblink> weblinks =  weblinksRepository.findAll();
        if (weblinks == null) {
          throw new ResourceNotFoundException("not found","id", "weblink");
        } else {
            wdto = weblinks.stream().map(weblinkMapper::toDto).toList();
            return wdto;
        }

    }
    /**
     * @param bkmk
     * @return
     */
    @Override
    public WeblinkDto updateWeblinks(WeblinkDto change) {
        Weblink weblink = weblinksRepository.save(weblinkMapper.toEntity(change));
        return  weblinkMapper.toDto(weblink);
    }
    /**
     * @param bkmk
     * @return
     */
    @Override
    public boolean deleteWeblinks(long id) {
        try {
            weblinksRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

