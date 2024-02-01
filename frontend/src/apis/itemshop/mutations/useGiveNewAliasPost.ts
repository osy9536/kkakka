// /api/friends/alias?email=osy9536@kakao.com
// 칭호 추가하기 - 칭호지정권 구입시 발동

import { useMutation } from "@tanstack/react-query";
import { useItemshopStore } from "@/stores/ItemshopStore";
import { useShallow } from "zustand/react/shallow";

const { ,  } = useItemshopStore(
  useShallow((state) => ({
    items: state.items,
    fetchItems: state.fetchItems,
  }))
);

const useGiveNewAliasPost = () => {
  return useMutation(fetchDmList, {
    onSuccess: () => {
      console.log("새로운 채팅방 생성하기 성공");
    },
    onError: (error: any) => {
      console.error("새로운 채팅방 생성하기 실패", error);
    },
  });
};
export default useGiveNewAliasPost;