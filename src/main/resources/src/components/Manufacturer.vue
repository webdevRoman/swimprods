<template lang="pug">
.manufacturer
  .title Производитель
  Loader(title="Производим товар...", v-if="isProducing")
  button.btn(:disabled="isProducing") Произвести товар
</template>

<script>
import Loader from './Loader.vue'

export default {
  name: 'Manufacturer',
  components: {
    Loader
  },
  data() {
    return {
      isProducing: false
    }
  },
  // computed: {
  //   count() {
  //     return this.$store.getters.count
  //   }
  // }
}
</script>