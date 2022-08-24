package com.favshare.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.favshare.dto.FeedDto;
import com.favshare.dto.FeedUserIdDto;
import com.favshare.dto.IdFeedImageUrlDto;
import com.favshare.dto.IdNameDto;
import com.favshare.entity.FeedEntity;
import com.favshare.entity.PopInFeedEntity;
import com.favshare.entity.UserEntity;
import com.favshare.repository.FeedRepository;
import com.favshare.repository.PopInFeedRepository;
import com.favshare.repository.UserRepository;

import antlr.collections.List;

@Service
public class FeedService {

	@Autowired
	private FeedRepository feedRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PopInFeedRepository popInFeedRepository;

	public void insertFeed(int userId) {
		FeedEntity feedEntity = new FeedEntity();
		UserEntity userEntity = userRepository.findById(userId).get();
		if (feedRepository.countFeedByUserId(userId) == 0) {
			feedEntity = feedEntity.builder().name("피드").isFirst(true).feedImageUrl(null).userEntity(userEntity)
					.build();
		} else {
			feedEntity = feedEntity.builder().name("피드").isFirst(false).feedImageUrl(null).userEntity(userEntity)
					.build();
		}
		feedRepository.save(feedEntity);
	}

	public void deleteFeed(int feedId) {
		feedRepository.deleteById(feedId);
	}

	public void updateFeedName(IdNameDto idNameDto) {
		FeedEntity feedEntity;
		feedEntity = feedRepository.findById(idNameDto.getId()).get();
		feedEntity.changeName(idNameDto.getName());
		feedRepository.save(feedEntity);
	}

	public void updateFeedImage(IdFeedImageUrlDto idFeedImageUrlDto) {
		FeedEntity feedEntity;
		feedEntity = feedRepository.findById(idFeedImageUrlDto.getId()).get();
		feedEntity.changeImageUrl(idFeedImageUrlDto.getFeedImageUrl());
		feedRepository.save(feedEntity);
	}

	public void updateFirstFeed(FeedUserIdDto feedUserIdDto) {
		FeedEntity newFeedEntity, oldFeedEntity;
		newFeedEntity = feedRepository.findById(feedUserIdDto.getFeedId()).get();
		newFeedEntity.changeIsFirst();

		int oldFirstFeedId = feedRepository.findFirstId(feedUserIdDto.getUserId());
		oldFeedEntity = feedRepository.findById(oldFirstFeedId).get();
		oldFeedEntity.changeIsNotFirst();

		feedRepository.save(newFeedEntity);
		feedRepository.save(oldFeedEntity);
	}

}
