const pagecard={
   template:
    `
       <ul class="pagination">
         <li v-if="$parent.startPage>1"><a class="nav-link" @click="$parent.prev($parent.startPage-1)">&lt;</a></li>
         <li v-for="i in $parent.range($parent.startPage,$parent.endPage)" :class="i===$parent.curpage?'active':''"><a class="nav-link" @click="$parent.pageChange(i)">{{i}}</a></li>
         <li v-if="$parent.endPage<$parent.totalpage"><a class="nav-link" @click="$parent.next($parent.endPage+1)">&gt;</a></li>
       </ul>
    `
}