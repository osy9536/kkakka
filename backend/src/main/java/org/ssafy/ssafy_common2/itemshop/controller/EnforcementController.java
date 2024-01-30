package org.ssafy.ssafy_common2.itemshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.ssafy.ssafy_common2._common.response.ApiResponseDto;
import org.ssafy.ssafy_common2._common.response.MsgType;
import org.ssafy.ssafy_common2._common.response.ResponseUtils;
import org.ssafy.ssafy_common2._common.security.UserDetailsImpl;
import org.ssafy.ssafy_common2.itemshop.dto.request.EnforcementCreateRequestDto;
import org.ssafy.ssafy_common2.itemshop.dto.response.EnforcementCreateResponseDto;
import org.ssafy.ssafy_common2.itemshop.service.EnforcementService;
import org.ssafy.ssafy_common2.user.entity.User;
import org.ssafy.ssafy_common2.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EnforcementController {

    private final UserService userService;
    private final EnforcementService enforcementService;

    @PostMapping("/friends/megaphone")
    public ApiResponseDto<EnforcementCreateResponseDto> addEnforcement(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                                       @RequestParam("email") String defenderEmail,
                                                                       @RequestBody EnforcementCreateRequestDto requestDto) {

        User attacker = userDetails.getUser();
        User defender = userService.validateUserByEmail(defenderEmail);

        return ResponseUtils.ok(enforcementService.addEnforcement(attacker, defender, requestDto), MsgType.DATA_SUCCESSFULLY);
    }
}
